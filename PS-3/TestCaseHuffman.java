import java.util.*;
/**
 * @Author Ikenna Nwafor
 * @Purpose Test boundary cases

 */public class TestCaseHuffman extends HuffmanImplementation{
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("\nsimpleText.txt");
            // Create a new HuffmanImplementation object
            HuffmanImplementation huffman = new HuffmanImplementation();
            // Create a map to store the frequency of each character
            Map<Character, Long> frequencyMap = new HashMap<>();
            // Read the file and count the frequency of each character
            frequencyMap = huffman.countFrequencies("PS-3/simpleText.txt");
            // Create a code tree from the frequency map
            BinaryTree<CodeTreeElement> codeTree = huffman.makeCodeTree(frequencyMap);
            // Print the code tree
            System.out.println("CodeTree:\n" + codeTree);
            // Compute the codes for each character in the tree
            Map<Character, String> codeMap = huffman.computeCodes(codeTree);
            System.out.println("CodeMap:");
            // Print the code map
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                System.out.println("Character: " + entry.getKey() + " Code: " + entry.getValue());
            }
            // Compression
            huffman.compressFile(codeMap, "PS-3/simpleText.txt", "ps3/simpleTextCompressed.txt");
            // Decompression
            huffman.decompressFile("PS-3/simpleTextCompressed.txt", "PS-3/simpleTextDecompressed.txt", codeTree);
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            System.out.println("\nEmpty.txt");
            // Create a new HuffmanImplementation object
            HuffmanImplementation huffman = new HuffmanImplementation();
            // Create a map to store the frequency of each character
            Map<Character, Long> frequencyMap = new HashMap<>();
            // Read the file and count the frequency of each character
            frequencyMap = huffman.countFrequencies("PS-3/empty.txt");
            // Create a code tree from the frequency map
            BinaryTree<CodeTreeElement> codeTree = huffman.makeCodeTree(frequencyMap);
            // Print the code tree
            System.out.println("Codetree:\n" + codeTree);
            // Compute the codes for each character in the tree
            Map<Character, String> codeMap = huffman.computeCodes(codeTree);
            System.out.println("CodeMap:");
            // Print the code map
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                System.out.println("Character: " + entry.getKey() + " Code: " + entry.getValue());
            }
            if (codeMap.isEmpty()) {
                System.out.println("Empty file, no codes to print");
            }
            // Compression
            huffman.compressFile(codeMap, "PS-3/empty.txt", "PS-3/emptyCompressed.txt");
            // Decompression
            huffman.decompressFile("PS-3/emptyCompressed.txt", "PS-3/emptyDecompressed.txt", codeTree);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("\nsingleChar.txt");
            // Create a new HuffmanImplementation object
            HuffmanImplementation huffman = new HuffmanImplementation();
            // Create a map to store the frequency of each character
            Map<Character, Long> frequencyMap = new HashMap<>();
            // Read the file and count the frequency of each character
            frequencyMap = huffman.countFrequencies("PS-3/singleChar.txt");
            // Create a code tree from the frequency map
            BinaryTree<CodeTreeElement> codeTree = huffman.makeCodeTree(frequencyMap);
            // Print the code tree
            System.out.println("CodeTree:\n" + codeTree);
            // Compute the codes for each character in the tree
            Map<Character, String> codeMap = huffman.computeCodes(codeTree);
            System.out.println("CodeMap:\n");
            // Print the code map
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                System.out.println("Character: " + entry.getKey() + " Code: " + entry.getValue());
            }
            // Compression
            huffman.compressFile(codeMap, "PS-3/singleChar.txt", "PS-3/singleCharCompressed.txt");
            // Decompression
            huffman.decompressFile("PS-3/singleCharCompressed.txt", "PS-3/singleCharDecompressed.txt", codeTree);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("\nMultiSingleCharHuffman.txt");
            // Create a new HuffmanImplementation object
            HuffmanImplementation huffman = new HuffmanImplementation();
            // Create a map to store the frequency of each character
            Map<Character, Long> frequencyMap = new HashMap<>();
            // Read the file and count the frequency of each character
            frequencyMap = huffman.countFrequencies("PS-3/MultiSingleCharHuffman.txt");
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
            huffman.compressFile(codeMap, "PS-3/MultiSingleCharHuffman.txt", "PS-3/MultiSingleCharHuffmanCompressed.txt");
            // Decompression
            huffman.decompressFile("PS-3/MultiSingleCharHuffmanCompressed.txt", "PS-3/MultiSingleCharHuffmanDecompressed.txt", codeTree);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
