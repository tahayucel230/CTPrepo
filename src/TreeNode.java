public class TreeNode {
    TreeNode[] children= {null,null,null,null};

    String name;
    int depth;

    public TreeNode(String name){
        this.name = name;
        this.depth = 0;

        //
        //System.out.println(name + " :name/1/depth: " + depth);
        //

    }

    private TreeNode(String name, int depth){
        this.name = name;
        this.depth = depth;

        //
        //System.out.println(name + " :name/2/depth: " + depth);
        //

    }

    public void newNode(String parent, String newNode){
        findNodeWithName(parent).addChild(newNode);

        //
        //System.out.println(findNodeWithName(parent).name + " :name   within new node");
        //

    }

    public void addChild(String name){
        for (int childID = 0; childID < 4; childID++){
            if (children[childID] == null){
                children[childID] = new TreeNode(name, (this.depth + 1));

                //
                //System.out.println(children[childID].name + " -> children[childID].name");
                //

                break;
        
            }
        }
    }

    public TreeNode findNodeWithName(String requestedName){

        if (name.equals(requestedName)){

            //
            //System.out.println(name.equals(requestedName) + " -> name.equals(requestedName) :: " + name + " <- name/requested name -> " + requestedName);
            //
    
            return this;
        }

        for (int childrenID = 0; (childrenID<4); childrenID++){
            if (children[childrenID] != null){
                
                //
                //System.out.println(children[childrenID].name + " -> children[childrenID].name");
                //
    
                if (children[childrenID].findNodeWithName(requestedName) != null){
                    
                    //
                    //System.out.println("^^ and they found it");
                    //
    
                    return children[childrenID].findNodeWithName(requestedName);
                }
            }
        }

        //
        //System.out.println("couldnt find it");
        //

        return null;
    }
}
