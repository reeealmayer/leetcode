package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubfoldersFromTheFileSystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        for (String path : folder) {
            // Если result пуст или текущий путь не под-папка последнего в result
            if (result.isEmpty() || !path.startsWith(result.getLast() + "/")) {
                result.add(path);
            }
        }

        return result;
    }
}
