package sgr.st.compute;

import java.util.ArrayList;
import java.util.List;

public class Combination <T>{
	List<T[]> combinationList;
	public Combination() {
		combinationList = new ArrayList<T[]>();
	}


	/**
	 * 与えられたリスト内の各集合から１つずつを組み合わせて生成される列の集合を作成します．
	 * 具体的には，Nコの集合それぞれから要素を１つずつ取ってきて作るサイズNの列全体の集合をリストとして作成します．
	 * @param patternList N群のグループ．各グループの大きさはバラバラでよい．
	 * @param emptyArray サイズN（＝patternList.size()）の空の配列.ほんとはnew T[]したかったができないので
	 * @return N群それぞれから１つずつ集めて作った列の集合．要素のサイズはN．
	 */
	public List<T[]> combi(List<T[]> patternList, T[] emptyArray) {
		combi(combinationList, patternList, emptyArray, patternList.size());
		return combinationList;
	}

	private void combi(List<T[]> combinationList, List<T[]> patternList, T[] pose, int now) {
		for(T joint:patternList.get(patternList.size() - now)) {
			pose[patternList.size()-now] = joint;
			if(now == 1) {
				combinationList.add(pose.clone());
			}else {
				combi(combinationList, patternList, pose, now-1);
			}
		}
	}
}
