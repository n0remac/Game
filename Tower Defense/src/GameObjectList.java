import java.util.LinkedList;
import java.util.Stack;

public class GameObjectList {
    LinkedList<GameObject> gameObject = new LinkedList<GameObject>(); //this should probably be separated into two separate lists eventual. 1 for monsters and 1 for players.
    Stack<Monster> monsters =new Stack<Monster>();




    public LinkedList<GameObject> getObjectList(){
        return gameObject;
    }

    public void addGameObject(GameObject obj){
        gameObject.add(obj);
    }

    public void removeGameObject(GameObject obj){
        int stop=gameObject.size();
        for(int i=0; i<=stop;i++){
            if(gameObject.get(i).ID==obj.ID)
                gameObject.get(i).setType(Tile.BLANKSPACE);
            gameObject.remove(i);
            break;
        }

    }

    //gets the first player object in the gameobject list.
    public GameObject getPlayer(){
        for(GameObject obj:gameObject){
            if(obj.getType().compareTo(Tile.PLAYER)==0){
                return obj;
            }
        }
        return null;
    }
}
