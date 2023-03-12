public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 140);
        map.put("Australia", 3);

        System.out.println(map.keySet());
        System.out.println(map.containsKey("India"));
        System.out.println(map.get("Australia"));
        System.out.println(map.get("India"));
        System.out.println(map.size());
        System.out.println(map.remove("India"));
        System.out.println(map.size());
        System.out.println(map.keySet());
    }
}