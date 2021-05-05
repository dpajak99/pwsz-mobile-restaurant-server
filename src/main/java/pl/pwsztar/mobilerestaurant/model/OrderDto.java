package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "zamowienie", schema = "restauracja")
public class OrderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zamowienia")
    private int id;

    @OneToOne()
    @JoinColumn(name = "id_pracownika", referencedColumnName = "id_pracownika")
    private WorkerDto worker;

    @OneToOne()
    @JoinColumn(name = "id_klienta", referencedColumnName = "id_klienta")
    private ClientDto client;

    @OneToOne()
    @JoinColumn(name = "id_oceny_zamowienia", referencedColumnName = "id_oceny_zamowienia")
    private OrderRateDto rate;

    @OneToOne()
    @JoinColumn(name = "id_platnosci", referencedColumnName = "id_platnosci")
    private PaymentDataDto paymentData;

    @Column(name = "realizacja_status")
    private String realizationStatus;

    @Column(name = "uwagi_dod")
    private String comments;

    public OrderDto() {
        super();
    }

    public OrderDto(int id, WorkerDto worker, ClientDto client, OrderRateDto rate, PaymentDataDto paymentData, String realizationStatus, String comments) {
        this.id = id;
        this.worker = worker;
        this.client = client;
        this.rate = rate;
        this.paymentData = paymentData;
        this.realizationStatus = realizationStatus;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkerDto getWorker() {
        return worker;
    }

    public void setWorker(WorkerDto worker) {
        this.worker = worker;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public OrderRateDto getRate() {
        return rate;
    }

    public void setRate(OrderRateDto rate) {
        this.rate = rate;
    }

    public PaymentDataDto getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentDataDto paymentData) {
        this.paymentData = paymentData;
    }

    public String getRealizationStatus() {
        return realizationStatus;
    }

    public void setRealizationStatus(String realizationStatus) {
        this.realizationStatus = realizationStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
          "id=" + id +
          ", worker=" + worker +
          ", client=" + client +
          ", rate=" + rate +
          ", paymentData=" + paymentData +
          ", realizationStatus='" + realizationStatus + '\'' +
          ", comments='" + comments + '\'' +
          '}';
    }
}
