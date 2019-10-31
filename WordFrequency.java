import java.util.Map;
import java.util.TreeMap;

public class WordFrequency {
	private static Map<String, Integer> freq = new TreeMap<String, Integer>();

	public static void main(String[] args) {
		wordFrequency(
				"Nước Việt Nam có quyền hưởng tự do và độc lập, và thực sự trở thành nước tự do và độc lập. Toàn thể dân tộc Việt Nam quyết đem tất cả tinh thần và lực lượng, tính mạng và của cái để giữ vững nền tự do, độc lập ấy" 
				);
	}
	private static boolean match(String word, String regex) {
		if (word.matches(regex)) {
			return true;
		}
		return false;
	}

	private static void wordFrequency(String str) {
		//Tách các từ trong văn bản theo khoảng trống, dấu phẩy, dấu chấm,...
		String[] array = str.split("\\s+|,\\s*|\\.\\s*|\\:\\s*|\\.\\.\\.\\s*|\\;\\s*");
		for (String s : array) {
			if (!match(s, "(\\d+\\.)+\\d+|\\s*")) {
				if (!freq.containsKey(s.toLowerCase())) {
					freq.put(s.toLowerCase(), 1);
				} else {
					freq.replace(s.toLowerCase(), freq.get(s.toLowerCase()) + 1);
				}
			}
		}
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
