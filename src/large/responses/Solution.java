package large.responses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static final Scanner scan=new Scanner(System.in);

	static String createBigResponseFile() throws IOException{
		String fileName = scan.nextLine();
		URL path = Solution.class.getResource(fileName);
		File f = new File(path.getFile());
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String s;
		int count=0;
		long totalBytes = 0;
		while ((s=reader.readLine()) != null) {
			String[] fields = s.split("\\s+");
			Integer bytes = Integer.parseInt(fields[fields.length-1]);
			if(bytes>5000){
				count++;
				totalBytes+=bytes;
			}
		}
		List<String> lines = new ArrayList();
		lines.add(count+"");
		lines.add(totalBytes+"");
		String newFileName = "bytes_"+fileName;
		Path newfile = Paths.get(newFileName);
		Files.write(newfile, lines, Charset.forName("UTF-8"));
		return newFileName;
	}
	public static void main(String[] args) {
		try {
			System.out.println(createBigResponseFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
