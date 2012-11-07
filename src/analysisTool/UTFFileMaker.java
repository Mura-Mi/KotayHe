/**
 * 
 */
package analysisTool;

import java.io.File;

/**
 * @author murakamitakuya
 *
 */
public class UTFFileMaker {

	private static final UTFFileMaker INSTANCE = new UTFFileMaker();
	
	
	private UTFFileMaker(){
		
	}
	
	public static UTFFileMaker getInstance(){
		return INSTANCE;
	}
	
	public File getUTFFile(){
		// TODO つくる！
		return null;
	}
}