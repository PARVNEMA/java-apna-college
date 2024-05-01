public class recur {
    public static void rd(String str,int idx ,StringBuilder newstr,boolean map[]) {
      if(idx==str.length()){
        System.out.println(newstr);
        return;
      }
      //base
      char curr=str.charAt(idx);
      if(map[curr-'a']==true){
        rd(str, idx+1, newstr, map);
      }
      else{map[curr-'a']=true;
        rd(str, idx+1, newstr.append(curr), map);
      }


    } 

    
    public static void main(String args[]){
        String str="czecoslovakia";

        rd(str, 0, new StringBuilder("") , new boolean[26]);
    }
  }
