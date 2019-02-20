package sgr.st.thread.lib;

public abstract class OperatableThread extends Thread {
	private boolean end;
	private boolean stop;

	public OperatableThread(){
		end = false;
		stop = false;
	}

	public final void run() {
		while(!end){
			doRepeatedTask();
			try {
				synchronized(this){
					if (stop && !end) wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract void doRepeatedTask();

	public synchronized void halt() {
		stop = true;
	}

	public synchronized void restart() {
		stop = false;
		notify();
	}

	public synchronized void close(){
		if(stop == true)
			notifyAll();
		stop = true;
		end = true;
	}

	public boolean isEnd() {
		return end;
	}

	public boolean isStop() {
		return stop;
	}

}
