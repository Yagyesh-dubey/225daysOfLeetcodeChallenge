
    public int[] restoreArray(int[][] adjacentPairs) {
        Set<Integer> nodes = new HashSet<Integer>();
        Map<Integer, Integer> edges = new HashMap();
        Map<Integer, List<Integer>> linkedlist = new HashMap();
        for(int[] i: adjacentPairs){
            for(int j=0; j<2; j++) {
                if (nodes.contains(i[j])) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    int one = edges.get(i[j]);
                    edges.remove(i[j]);
                    tmp.add(one);
                    if(j==0)
                        tmp.add(i[1]);
                    else
                        tmp.add(i[0]);
                    linkedlist.put(i[j], tmp);
                } else {
                    if(j==0)
                        edges.put(i[0], i[1]);
                    else
                        edges.put(i[1], i[0]);
                }
                nodes.add(i[j]);
            }
        }
        int[] res = new int[nodes.size()];
        boolean start=true;
        int curr=0;
        for(Map.Entry<Integer, Integer> e1: edges.entrySet()){
            if(start) {
                start =false;
                res[curr++] = e1.getKey();
                res[curr++] = e1.getValue();
                int search = e1.getValue();
                while(linkedlist.containsKey(search)){
                    List<Integer> tmp = linkedlist.get(search);
                    if(tmp.get(0)==res[curr-2]){
                        res[curr++] = tmp.get(1);
                        search = tmp.get(1);
                    } else{
                        res[curr++] = tmp.get(0);
                        search = tmp.get(0);
                    }
                }
            }
        }
        return res;
    }
