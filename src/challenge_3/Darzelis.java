package challenge_3;


public class Darzelis {
	private int darz_id;
    private String school_name;
    private int type_id;
    private String type_label;
    private int lan_id;
    private String lan_label;
    private int childs_count;
    private int free_space;
    
    //constructor:
    public Darzelis(int darz_id, String school_name, int type_id, String type_label, int lan_id, String lan_label,
			int childs_count, int free_space) {
		super();
		this.darz_id = darz_id;
		this.school_name = school_name;
		this.type_id = type_id;
		this.type_label = type_label;
		this.lan_id = lan_id;
		this.lan_label = lan_label;
		this.childs_count = childs_count;
		this.free_space = free_space;
	}
    
	//getters and setters:
	public int getDarz_id() {
		return darz_id;
	}
	public void setDarz_id(int darz_id) {
		this.darz_id = darz_id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_label() {
		return type_label;
	}
	public void setType_label(String type_label) {
		this.type_label = type_label;
	}
	public int getLan_id() {
		return lan_id;
	}
	public void setLan_id(int lan_id) {
		this.lan_id = lan_id;
	}
	public String getLan_label() {
		return lan_label;
	}
	public void setLan_label(String lan_label) {
		this.lan_label = lan_label;
	}
	public int getChilds_count() {
		return childs_count;
	}
	public void setChilds_count(int childs_count) {
		this.childs_count = childs_count;
	}
	public int getFree_space() {
		return free_space;
	}
	public void setFree_space(int free_space) {
		this.free_space = free_space;
	}

    
}
