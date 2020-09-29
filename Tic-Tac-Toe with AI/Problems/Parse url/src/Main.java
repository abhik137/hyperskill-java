import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        String[] urlSplit = url.split("\\?");
        String[] query = urlSplit[1].split("&");

        Map<String, String> queryParams = new LinkedHashMap<>();

        for (String param: query) {
            String[] pair = param.split("=");
            if (pair.length < 2 && !pair[0].equals("pass")) {
                queryParams.put(pair[0], "not found");
                continue;
            }
            queryParams.put(pair[0], pair[1]);
        }

        if (queryParams.containsKey("pass") && queryParams.get("pass") != null) {
            queryParams.put("password", queryParams.get("pass"));
        }

        // System.out.println(Arrays.toString(query));
        for (String k: queryParams.keySet()) {
            System.out.println(k + " : " + queryParams.get(k));
        }
    }
}