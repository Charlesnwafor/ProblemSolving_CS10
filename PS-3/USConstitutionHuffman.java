import java.util.*;


/**
 * @Author Ikenna Nwafor
 * @Purpose To check that the implementation works on the US Constitution file
 */

public class USConstitutionHuffman extends HuffmanImplementation {
    public static void main(String[] args) throws Exception {
        try {
            // Create a new HuffmanImplementation object
            HuffmanImplementation huffman = new HuffmanImplementation();
            // Create a map to store the frequency of each character
            Map<Character, Long> frequencyMap = new HashMap<>();
            // Read the file and count the frequency of each character
            frequencyMap = huffman.countFrequencies("PS-3/USConstitution.txt");
            // Create a code tree from the frequency map
            BinaryTree<CodeTreeElement> codeTree = huffman.makeCodeTree(frequencyMap);
            System.out.println("CodeTree:\n");
            // Print the code tree
            System.out.println(codeTree);
            // Compute the codes for each character in the tree
            Map<Character, String> codeMap = huffman.computeCodes(codeTree);
            System.out.println("CodeMap:\n");
            // Print the code map
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                System.out.println("Character: " + entry.getKey() + " Code: " + entry.getValue());
            }
            // Compression
            huffman.compressFile(codeMap, "PS-3/USConstitution.txt", "PS-3/USConstitutionCompressed.txt");
            // Decompression
            huffman.decompressFile("PS-3/USConstitutionCompressed.txt", "PS-3/USConstitutionDecompressed.txt", codeTree);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
