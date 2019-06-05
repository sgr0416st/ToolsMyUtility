package sgr.st.compute;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinationTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testCombi() {
		final Integer[] testPatern1 = {0};
		final Integer[] testPatern2 = {1, 2};
		final Integer[] testPatern3 = {3, 4, 5};
		final Integer[][] combination = {
				{0, 1, 3},
				{0, 1, 4},
				{0, 1, 5},
				{0, 2, 3},
				{0, 2, 4},
				{0, 2, 5}
		};

		// TODO 自動生成されたメソッド・スタブ
		List<Integer[]> patternList = new ArrayList<Integer[]>();
		patternList.add(testPatern1);
		patternList.add(testPatern2);
		patternList.add(testPatern3);

		Combination<Integer> player = new Combination<Integer>();
		List<Integer[]> list = player.combi(patternList, new Integer[patternList.size()]);
		assertArrayEquals(list.toArray(), combination);
	}

}
