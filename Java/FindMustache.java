public class FindMustache{

     public static void main(String []args){
        String[] arr={"{{","yash","}}","yash2","}}","{{","akash","}}"};
        String word="word",prv="",next="";
        for(String s:arr)
        {
            
            if(s.equals("{{") || s.equals("}}"))
            { 
                System.out.println(s);
                if(s.equals("{{")) prv=s;
                else if(s.equals("}}")) next=s;
                
            }
            else
            { 
                System.out.println(s+"=="+word);
                //System.out.println(next+"=====");
            }
            if("{{".equals(prv) && "}}".equals(next))System.out.println(true);
            if(s.equals("}}")) {prv="";next="";}
        }
     }
}