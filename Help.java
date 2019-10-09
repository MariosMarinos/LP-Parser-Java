import java.util.ArrayList;

public class Help {
	public static String diavasma_suntelewstwn (String line,ArrayList<String> c,ArrayList<Integer> index) {
		int i,temp2=0,j = 0;
		String temp = "";
			while (line.charAt(j)!='x') {
				temp = temp + line.charAt(j);
				j++;
			}
		line =line.substring(j);

		if ((j==1 && temp.equals("+")) || j==0)
			c.add("1");
		else if (j==1 && temp.equals("-"))
			c.add("-1");
		else if (j>=1 ) {
			if (temp.charAt(0)=='+')
				temp=temp.substring(1);
			c.add(temp);
		}
		j=0;
		while (line.charAt(j)!='-' && line.charAt(j)!='+' && j<line.length()-1) {
			j++;
		}
		temp=line.substring(0, j+1);
		int count = temp.length()-temp.replaceAll("x", "").length();
		if (!(temp.contains("-") && temp.contains("+")) && count>1) {
			System.out.println("There is an error. One sign is missing between variables.");
			System.exit(1);
		}
		//evresi deikti x.
		if (j==1 || j==line.length()-1)
			temp= line.substring(1,j+1);
		else
			temp=line.substring(1,j);
		if (temp.contains("+") || temp.contains("-") || temp.equals("")) {
			System.out.println("One index is missing from variables.");
			System.exit(1);
		}
		else {
			temp2=Integer.parseInt(temp);
			index.add(temp2);
		}
		return line=line.substring(j);
	}
}
