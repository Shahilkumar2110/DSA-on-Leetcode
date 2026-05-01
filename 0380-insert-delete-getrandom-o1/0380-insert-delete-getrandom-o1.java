class RandomizedSet {

    HashSet<Integer> set;
    ArrayList<Integer> list;
    Random rand;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {

        if(set.contains(val))
            return false;

        set.add(val);
        list.add(val);

        return true;
    }

    public boolean remove(int val) {

        if(!set.contains(val))
            return false;

        set.remove(val);
        list.remove(Integer.valueOf(val));

        return true;
    }

    public int getRandom() {

        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}