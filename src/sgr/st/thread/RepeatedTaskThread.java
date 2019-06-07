package sgr.st.thread;

public abstract class RepeatedTaskThread implements Runnable{

	/**
	 * スレッドが停止状態に向かっているかどうかを示すフラグです。
	 * 外部または内部からstopthread()び出された場合にtrueになります。
	 * それまではfalseです。
	 */
	protected boolean isStopped;

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

		while(!this.isStopped){
			doRepeatedTask();
		}

		doAfterTask();
	}

	/**
	 * スレッドが開始したら、まずこのメソッドを実行します。
	 * 流動的な初期化処理はここで行ってください。
	 * そのような処理が必要ない場合は、何も実行しなくて構いません。
	 */
	protected abstract void doBeforeTask();

	/**
	 * 繰り返し実行するタスクを記述してください。
	 * ここで記述されたタスクは原則的に、stopThread()が呼び出されるまで繰り返し実行されます。
	 */
	protected abstract void doRepeatedTask();


	/**
	 * stopThread()が呼ばれ、繰り返し実行されるタスクを終了した後にこのメソッドが呼び出されます。
	 * 後処理をここで行ってください。
	 */
	protected abstract void doAfterTask();

	/**
	 * このスレッドを停止させます。この関数を外部のスレッドから呼び出すことで、このスレッドを停止させることができます。
	 */
	public void stopThread() {
		isStopped  = true;
	}

	/**
	 * このスレッドが外部から停止命令を受けているかどうかを返します。
	 * @return このスレッドが停止処理の準備をしている、または実行している場合はtrue, そうでない場合はfalse
	 */
	public boolean isStopped() {
		return isStopped;
	}

}
