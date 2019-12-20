package checkparenthesis;

public class CheckParenthesis {

    public static boolean checkParenthesis(String string) {
                
                MyStack stack = new MyStack();
                if(string.isEmpty()){
                    return true;
                }
                for(int i=0;i<string.length();i++){
                    Character currentChar = string.charAt(i);                    
                    if(currentChar=='{'||currentChar=='('||currentChar=='['){
                        stack.push(currentChar);
                    }
                    //why not else=> to progress non parentesis
                    if(currentChar=='}'||currentChar==')'||currentChar==']'){
                        if(stack.isEmpty()){
                            return false;
                        }
                        Character lastChar = stack.top();
                        if(lastChar =='{' && currentChar =='}' || lastChar =='(' && currentChar ==')' || lastChar =='[' && currentChar ==']'){
                            stack.pop();
                        }else return false;
                    }
                }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
            String string = "(([{{}}]))";
            System.out.println(checkParenthesis(string));

        }        
    }

