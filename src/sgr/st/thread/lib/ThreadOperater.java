package sgr.st.thread.lib;

public class ThreadOperater<E extends OperatableThread>{

	protected E operatableThread;
	private boolean isSetThread;

	public ThreadOperater() {
		operatableThread = null;
		isSetThread = false;
	}

	public ThreadOperater(E operetableThread) {
		setThread(operetableThread);
	}

	public void setThread(E operetableThread) {
		this.operatableThread = operetableThread;
		isSetThread = true;
	}

	public E getThread() {
		return operatableThread;
	}

	public boolean isClosed() {
		return isSetThread;
	}

	public void start() {
		if(isSetThread)
			this.operatableThread.start();
	}

	public void restart() {
		if(isSetThread)
			this.operatableThread.restart();
	}

	public void halt() {
		if(isSetThread)
			this.operatableThread.halt();
	}

	public void close() {
		if(isSetThread)
			this.operatableThread.close();
			isSetThread =false;
	}

}
