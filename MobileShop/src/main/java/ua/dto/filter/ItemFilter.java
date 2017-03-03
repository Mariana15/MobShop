package ua.dto.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.Predicate;

public class ItemFilter {
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");

	private String search = "";
	
	private String maxPrice = "";
	
	private String minPrice = "";
	
	private Integer max;
	
	private Integer min;
	
	private List<Integer> producerIds = new ArrayList<>();
	private List<Integer> categoryIds = new ArrayList<>();
	private List<Integer> cameraIds = new ArrayList<>();
	private List<Integer> colorIds = new ArrayList<>();
	private List<Integer> diagonalIds = new ArrayList<>();
	private List<Integer> fcIds = new ArrayList<>();
	private List<Integer> memoryIds = new ArrayList<>();
	private List<Integer> nocIds = new ArrayList<>();
	private List<Integer> noscIds = new ArrayList<>();
	private List<Integer> osIds = new ArrayList<>();
	private List<Integer> tsIds = new ArrayList<>();
	private List<Integer> descriptionIds = new ArrayList<>();
	
	
	public List<Integer> getDescriptionIds() {
		return descriptionIds;
	}

	public void setDescriptionIds(List<Integer> descriptionIds) {
		this.descriptionIds = descriptionIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getCameraIds() {
		return cameraIds;
	}

	public void setCameraIds(List<Integer> cameraIds) {
		this.cameraIds = cameraIds;
	}

	public List<Integer> getColorIds() {
		return colorIds;
	}

	public void setColorIds(List<Integer> colorIds) {
		this.colorIds = colorIds;
	}

	public List<Integer> getDiagonalIds() {
		return diagonalIds;
	}

	public void setDiagonalIds(List<Integer> diagonalIds) {
		this.diagonalIds = diagonalIds;
	}

	public List<Integer> getFcIds() {
		return fcIds;
	}

	public void setFcIds(List<Integer> fcIds) {
		this.fcIds = fcIds;
	}

	public List<Integer> getMemoryIds() {
		return memoryIds;
	}

	public void setMemoryIds(List<Integer> memoryIds) {
		this.memoryIds = memoryIds;
	}

	public List<Integer> getNocIds() {
		return nocIds;
	}

	public void setNocIds(List<Integer> nocIds) {
		this.nocIds = nocIds;
	}

	public List<Integer> getNoscIds() {
		return noscIds;
	}

	public void setNoscIds(List<Integer> noscIds) {
		this.noscIds = noscIds;
	}

	public List<Integer> getOsIds() {
		return osIds;
	}

	public void setOsIds(List<Integer> osIds) {
		this.osIds = osIds;
	}

	public List<Integer> getTsIds() {
		return tsIds;
	}

	public void setTsIds(List<Integer> tsIds) {
		this.tsIds = tsIds;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	

	public String getMinPrice() {
		return minPrice;
	}

	

	public static Pattern getPattern() {
		return PATTERN;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public List<Integer> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}



}
