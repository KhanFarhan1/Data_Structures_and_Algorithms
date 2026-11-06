class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer , TreeNode> freq = new HashMap<>();
        HashSet<Integer> child = new HashSet<>();
        TreeNode root = null;
        for(int i = 0 ;i < descriptions.length ; i++){
            child.add(descriptions[i][1]);
        }
        for(int i = 0 ;i<descriptions.length ; i++){
            //parent
            TreeNode parent = null;
            if(freq.getOrDefault(descriptions[i][0], null) == null){
                parent = new TreeNode(descriptions[i][0]);
                freq.put(descriptions[i][0], parent);
            }else{
                parent = freq.get(descriptions[i][0]);
            }
            //child
            TreeNode children = null;
            if(freq.getOrDefault(descriptions[i][1], null) == null){
                children = new TreeNode(descriptions[i][1]);
                freq.put(descriptions[i][1], children);
            }else{
                children = freq.get(descriptions[i][1]);
            }
            //connection
            if(descriptions[i][2] == 0){
                parent.right = children;
            }else{
                parent.left = children;
            }
            //detect root
            if(!child.contains(descriptions[i][0])){
                root = freq.get(descriptions[i][0]);
            }
        }
        return root;
    }
}
