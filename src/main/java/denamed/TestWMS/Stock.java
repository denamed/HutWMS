package denamed.TestWMS;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Stock")
@Table(name = "stock")
public class Stock {
    @Id
    @SequenceGenerator(
            name = "stock_id",
            sequenceName = "stock_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "stock_id"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "palletid")
    private String palletid;

    @Column(name = "catNo")
    private int catNo;

    @Column(name = "area")
    private String area;

    @Column(name = "ray")
    private int ray;

    @Column(name = "spot")
    private int spot;

    @Column(name = "level")
    private int level;

    @Column(name = "seq")
    private int seq;

    public Stock(String palletid,
                 int catNo,
                 String area,
                 int ray,
                 int spot,
                 int level,
                 int seq) {
        this.palletid = palletid;
        this.catNo = catNo;
        this.area = area;
        this.ray = ray;
        this.spot = spot;
        this.level = level;
        this.seq = seq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalletid() {
        return palletid;
    }

    public void setPalletid(String palletid) {
        this.palletid = palletid;
    }

    public int getCatNo() {
        return catNo;
    }

    public void setCatNo(int catNo) {
        this.catNo = catNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getRay() {
        return ray;
    }

    public void setRay(int ray) {
        this.ray = ray;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", palletid='" + palletid + '\'' +
                ", catNo=" + catNo +
                ", area='" + area + '\'' +
                ", ray=" + ray +
                ", spot=" + spot +
                ", level=" + level +
                ", seq=" + seq +
                '}';
    }
}
