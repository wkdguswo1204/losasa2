package losasa2.SQL;

public class LosSQL {

	public final int SEL_LOS = 1001;
	
	public String getSQL(int code) {
		StringBuffer buff  = new StringBuffer();
		switch(code) {
		case SEL_LOS:
			buff.append("SELECT ");
			buff.append("mno, name, admin, msg, jdate");
			buff.append("FROM ");
			buff.append("");
		}
		
		return buff.toString();
	}
}
