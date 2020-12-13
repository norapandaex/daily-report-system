package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name = "reports")
@NamedQueries({
        @NamedQuery(
                name = "getAllReports",
                query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getReportsCount",
                query = "SELECT COUNT(r) FROM Report AS r"
                ),
        @NamedQuery(
                name = "getMyAllReports",
                query = "SELECT r FROM Report AS r WHERE r.employee = :employee ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getMyReportsCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :employee"
                ),
        @NamedQuery(
                name = "getSearchName",
                query = "SELECT r FROM Report AS r WHERE r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeyword",
                query = "SELECT r FROM Report AS r WHERE r.content LIKE :skeyword OR r.title LIKE :skeyword ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndKeyword",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchDate",
                query = "SELECT r FROM Report AS r WHERE r.report_date BETWEEN :adate AND :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndDate",
                query = "SELECT r FROM Report AS r WHERE r.report_date BETWEEN :adate AND :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordAndDate",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date BETWEEN :adate AND :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchAll",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date BETWEEN :adate AND :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchAfterDate",
                query = "SELECT r FROM Report AS r WHERE r.report_date >= :adate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndAfterDate",
                query = "SELECT r FROM Report AS r WHERE r.report_date >= :adate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordAndAfterDate",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date >= :adate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchAllAfterDate",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date >= :adate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchBeforeDate",
                query = "SELECT r FROM Report AS r WHERE r.report_date <= :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndBeforeDate",
                query = "SELECT r FROM Report AS r WHERE r.report_date <= :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordAndBeforeDate",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date <= :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchAllBeforeDate",
                query = "SELECT r FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date <= :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchNameCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.content LIKE :skeyword OR r.title LIKE :skeyword ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.report_date BETWEEN :adate AND :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndKeywordCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.report_date BETWEEN :adate AND :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordAndDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date BETWEEN :adate AND :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchAllCount",
                query = "SELECT Count(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date BETWEEN :adate AND :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchAfterDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.report_date >= :adate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndAfterDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.report_date >= :adate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordAndAfterDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date >= :adate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchAllAfterDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date >= :adate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchBeforeDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.report_date <= :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchNameAndBeforeDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE r.report_date <= :bdate AND r.employee = :sname ORDER BY r.id DESC"
                ),
        @NamedQuery(
                name = "getSearchKeywordAndBeforeDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date <= :bdate ORDER BY r.report_date DESC"
                ),
        @NamedQuery(
                name = "getSearchAllBeforeDateCount",
                query = "SELECT COUNT(r) FROM Report AS r WHERE (r.content LIKE :skeyword OR r.title LIKE :skeyword) AND r.report_date <= :bdate AND r.employee = :sname ORDER BY r.id DESC"
                )
})
@Entity
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "report_date", nullable = false)
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
