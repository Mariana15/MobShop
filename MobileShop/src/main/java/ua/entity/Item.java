package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "item", indexes=@Index(columnList = "price"))
public class Item extends AbstractEntity {


	@Column(name = "version", nullable = true)
	private Integer version;
	@Column(name = "_name")
	private String name;
	private BigDecimal price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producer")
	private Producer producer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_color")
	private Color color;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ts")
	public TypeSim ts;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_noc")
	private NumberOfCores noc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nosc")
	private NumberOfSimCards nosc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_diagonal")
	private Diagonal diagonal;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_memory")
	private Memory memory;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_camera")
	private Camera camera;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fc")
	private FrontCamera fc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_os")
	private OS os;
	@ManyToOne(fetch= FetchType.LAZY)
	private Description description;
	
	public Item() {

	}
	
	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	@ManyToMany(mappedBy="items")
	private List<User> users = new ArrayList<>();
	@Transient
	private MultipartFile file;
	

	public MultipartFile getFile() {
		return file;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public Item(String name, BigDecimal price, Producer producer,
			Category category, Color color, TypeSim ts,
			NumberOfCores noc, NumberOfSimCards nosc,
			Diagonal diagonal, Memory memory, Camera camera,
			FrontCamera fc, OS os) {
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
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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

	public List<User> getUsers() {
		return users;
	}



}
