package sgr.st.thread.exception;

public class AbortTaskException extends InterruptedException {
	private static final long serialVersionUID = 1L;

	// コンストラクタ
	public AbortTaskException(String msg){
		super(msg);
	}

}
