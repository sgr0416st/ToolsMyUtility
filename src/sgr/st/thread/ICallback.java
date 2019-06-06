package sgr.st.thread;

/**
 * @author satousuguru
 *
 * コールバック関数を定義するインターフェース。
 * コールバックによって呼び出されるメソッドを持つクラスにこのインターフェースを実装し、
 * コールバックしたい箇所でこのインターフェースを実装したクラスのcallbackメソッドを呼び出すことでコールバックを実現できる。
 *
 * @param <P> コールバック関数の引数
 * @param <R> コールバック関数の戻り値
 */
public interface ICallback<P, R> {
	   public R callback(P param);
}