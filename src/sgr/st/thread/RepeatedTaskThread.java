package sgr.st.thread;

import sgr.st.thread.exception.AbortTaskException;

/**
 * このクラスは、繰り返し処理をするスレッドの抽象モデルです。
 * 何らかの繰り返し期間が定まっていない何らかの繰り返し処理をする場合、このモデルを継承すると便利です。
 * 以下の様なライフサイクルとなっています。
 * コンストラクタ → スレッドstart → doBeforeTask() → doRepeatedTask()繰り返し → stopThread() → doAfterTask()
 *
 * @author satousuguru
 *
 */
public abstract class RepeatedTaskThread implements Runnable{

	/**
	 * スレッドが停止状態に向かっているかどうかを示すフラグです。
	 * 外部または内部からstopThread()び出された場合にtrueになります。
	 * それまではfalseです。
	 */
	private boolean isStopped;

	/**
	 * パラメータの初期化を行います。流動的な初期化処理はここでは行わないでください。
	 * また、オーバーロードやオーバーライド時は、原則として親クラスのコンストラクタを呼び出してください。
	 */
	public RepeatedTaskThread(){
		isStopped = false;
	}

	@Override
	public final void run() {
		doBeforeTask();
		doRightBeforeRepeatedTask();

		while(!this.isStopped){
			try {
				doRepeatedTask();
			} catch (InterruptedException e) {
				whenAbort();
			}
		}

		doRightAfterRepeatedTask();
		doAfterTask();
		close();
	}

	/**
	 * スレッドが開始したら、まずこのメソッドを実行します。
	 * 流動的な初期化処理がある場合はこのメソッドをオーバーライドしてください。
	 * そのような処理が必要ない場合は、何も実行しなくて構いません。
	 */
	protected abstract void doBeforeTask();

	/**
	 *  dobeforeTaskが終了した後、繰り返し実行されるタスクが始まる直前にこのメソッドが呼ばれます。
	 *  時間がかからず、直ちに終了する処理が存在する場合はオーバーライドしたこのメソッドの中で実行してください。
	 */
	protected void doRightBeforeRepeatedTask(){}

	/**
	 * 繰り返し実行するタスクを記述してください。
	 * ここで記述されたタスクは原則的に、stopThread()が呼び出されるまで繰り返し実行されます。
	 *
	 * @throws AbortTaskException stopThreadNow()メソッドが呼び出された時
	 */
	protected abstract void doRepeatedTask() throws AbortTaskException;

	/**
	 *  stopThread()によってタスクが終了した直後にこのメソッドが呼ばれます。
	 *  時間がかからず、直ちに終了する処理が存在する場合はオーバーライドしたこのメソッドの中で実行してください。
	 */
	protected void doRightAfterRepeatedTask(){}

	/**
	 * stopThread()が呼ばれ、繰り返し実行されるタスクを終了した後にこのメソッドが呼び出されます。
	 * 繰り返し処理が終わった後に実行したい処理がある場合はこのメソッドをオーバーライドしてください。
	 * そのような処理が必要ない場合は、何も実行しなくて構いません。
	 */
	protected abstract void doAfterTask();

	/**
	 * 終了処理を行います。オブジェクトの終了処理、破棄等はここで実行してください。
	 * そのような処理が必要ない場合は、何も実行しなくて構いません。
	 */
	protected abstract void close();

	/**
	 * このスレッドに対して停止要求を出します。
	 * このスレッドは停止要求を受けた後は、現在実行しているタスクが終了すると次のタスクを繰り返さずに、
	 * 事後処理へ向かいます。呼び出し時に実行中のタスクは中断しません。
	 */
	public void stopThread() {
		isStopped  = true;
	}

	/**
	 * このスレッドに対して即時停止要求を出します。
	 * このスレッドはこの要求を受けた後、AbortTaskExceptionを発行して直ちに実行しているタスクの終了を試みます。
	 * なお、doRepeatedTask()の実装によっては直ちに終了しない可能性があります。
	 * タスクが終了した後は、whenAbort()を呼び出して例外処理を行った後、事後処理へ向かいます。
	 *
	 * @throws AbortTaskException InterruptExeptionを継承した自作例外です。
	 * この関数は常に、このスレッドに対して即時終了要求を発行します。
	 *
	 */
	public void stopThreadNow() throws AbortTaskException{
		this.stopThread();
		throw new AbortTaskException("call : stopThreadNow");
	}

	/**
	 * stopThreadNow()によって即時停止要求の例外を発行した後の後処理をするメソッドです。
	 * 即時停止後に特別な処理をする必要がある場合は、このメソッドをオーバーライドしてください。
	 */
	public void whenAbort() {}

	/**
	 * このスレッドが外部から停止命令を受けているかどうかを返します。
	 * @return このスレッドが停止処理の準備をしている、または実行している場合はtrue, そうでない場合はfalse
	 */
	public boolean isStopped() {
		return isStopped;
	}

}
