class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {        
        List<String> result = new ArrayList<>();
        int nextWordIndex = 0;
        while(nextWordIndex < words.length){
            int endIndex = wordsAllowed(words, nextWordIndex, maxWidth);
            result.add(createLine(words, nextWordIndex, endIndex, maxWidth));
            nextWordIndex = endIndex + 1;
        }
        return result;        
    }
        
    
    private int wordsAllowed(String[] words, int startIndex, int maxWidth){
        int spaceLeft = maxWidth;
        int endIndex = startIndex;
        spaceLeft -= words[endIndex].length();
        
        while(endIndex+1 < words.length && spaceLeft >= 1 + words[endIndex+1].length() ) {
            spaceLeft -= 1 + words[endIndex+1].length();
            endIndex++;
        }
        return endIndex;        
    }
    
    
    private String createLine(String[] words, int startIndex, int endIndex, int maxWidth){
        StringBuilder sb = new StringBuilder(maxWidth);        
        
        // Last Line or a single word line
        if (endIndex == words.length-1 || endIndex == startIndex) {
            for(int i = startIndex; i < endIndex ; i++){
                sb.append(words[i]);
                sb.append(' ');
            }
            sb.append(words[endIndex]);
            for(int i = sb.length() + 1; i <= maxWidth; i++) sb.append(' ');
        }
                
        else{
            int spaceSlots = endIndex - startIndex;
            int totalSpacesRequired = maxWidth;
            
            for(int i =startIndex; i<= endIndex; i++){
                totalSpacesRequired -= words[i].length();
            }
           
            String commonSpace = " ".repeat(totalSpacesRequired / spaceSlots);
            int remainder = totalSpacesRequired % spaceSlots;
            
            int nextSpaceSlot = 1;
            for(int i = startIndex; i< endIndex; i++){
                sb.append(words[i]);
                sb.append(commonSpace);
                if (nextSpaceSlot++<= remainder) sb.append(' ');               
            }   
            sb.append(words[endIndex]);
        }
        return sb.toString();
    }
    
}
