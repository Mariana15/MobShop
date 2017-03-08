package ua.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Camera;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Description;
import ua.entity.Diagonal;
import ua.entity.FrontCamera;
import ua.entity.Memory;
import ua.entity.NumberOfCores;
import ua.entity.NumberOfSimCards;
import ua.entity.OS;
import ua.entity.Producer;
import ua.entity.TypeSim;

public class ItemForm {
	private int id;
	private String name;
	private String price;
	private Producer producer;
	private Category category;
	private Color color;
	public TypeSim ts;
	private NumberOfCores noc;
	private NumberOfSimCards nosc;
	private Diagonal diagonal;
	private Memory memory;
	private Camera camera;
	private FrontCamera fc;
	private OS os;
	private MultipartFile file;
	private String version;
	private Description description;

	public ItemForm() {

	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ItemForm(String name, String price, Producer producer, Category category, Color color, TypeSim ts, NumberOfCores noc, NumberOfSimCards nosc, Diagonal diagonal, Memory memory, Camera camera, FrontCamera fc, OS os,
			MultipartFile file) {
		super();
		this.name = name;
		this.price = price;
		this.producer = producer;
		this.category = category;
		this.color = color;
		this.ts = ts;
		this.noc = noc;
		this.nosc = nosc;
		this.diagonal = diagonal;
		this.memory = memory;
		this.camera = camera;
		this.fc = fc;
		this.os = os;
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TypeSim getTs() {
		return ts;
	}

	public void setTs(TypeSim ts) {
		this.ts = ts;
	}

	public NumberOfCores getNoc() {
		return noc;
	}

	public void setNoc(NumberOfCores noc) {
		this.noc = noc;
	}

	public NumberOfSimCards getNosc() {
		return nosc;
	}

	public void setNosc(NumberOfSimCards nosc) {
		this.nosc = nosc;
	}

	public Diagonal getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(Diagonal diagonal) {
		this.diagonal = diagonal;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public FrontCamera getFc() {
		return fc;
	}

	public void setFc(FrontCamera fc) {
		this.fc = fc;
	}

	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
