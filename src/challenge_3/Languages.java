package challenge_3;


public class Languages {
    private int lan_id;
    private String lan_label;
    private int childs_count;
    private int free_space;
    private double free_space_percentages;

	//constructor:
    public Languages(int lan_id, String lan_label, int childs_count, int free_space) {
		super();
		this.lan_id = lan_id;
		this.lan_label = lan_label;
		this.childs_count = childs_count;
		this.free_space = free_space;
	}

    //getters and setters
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
	
	public double getFree_space_percentages() {
		return free_space_percentages;
	}

	public void setFree_space_percentages(double free_space_percentages) {
		this.free_space_percentages = free_space_percentages;
	}
	
}
