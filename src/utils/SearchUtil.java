package utils;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import models.Employee;
import models.Report;

public class SearchUtil {

    public static Employee GetSearchNameEmployee(String search_name, EntityManager em) {
        Employee sname = em.createNamedQuery("getSearchNameEmployee", Employee.class)
                           .setParameter("sname", "%" + search_name + "%")
                           .getSingleResult();
        return sname;
    }

    public static List<Report> GetSearchName(Employee sname, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchName", Report.class)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchNameAndKeyword(Employee sname, String skeyword, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchNameAndKeyword", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchKeyword(String skeyword, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchKeyword", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchDate(Date adate, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchDate", Report.class)
                                  .setParameter("adate", adate)
                                  .setParameter("bdate", bdate)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchNameAndDate(Employee sname, Date adate, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchNameAndDate", Report.class)
                                  .setParameter("adate", adate)
                                  .setParameter("bdate", bdate)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchKeywordAndDate(String skeyword, Date adate, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchKeywordAndDate", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("adate", adate)
                                  .setParameter("bdate", bdate)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchAll(String skeyword,Employee sname, Date adate, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchAll", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("adate", adate)
                                  .setParameter("bdate", bdate)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchAfterDate(Date adate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchAfterDate", Report.class)
                                  .setParameter("adate", adate)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchNameAndAfterDate(Employee sname, Date adate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchNameAndAfterDate", Report.class)
                                  .setParameter("adate", adate)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchKeywordAndAfterDate(String skeyword, Date adate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchKeywordAndAfterDate", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("adate", adate)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchAllAfterDate(String skeyword,Employee sname, Date adate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchAllAfterDate", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("adate", adate)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchBeforeDate(Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchBeforeDate", Report.class)
                                  .setParameter("bdate", bdate)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchNameAndBeforeDate(Employee sname, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchNameAndBeforeDate", Report.class)
                                  .setParameter("bdate", bdate)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchKeywordAndBeforeDate(String skeyword, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchKeywordAndBeforeDate", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("bdate", bdate)
                                  .getResultList();
        return searches;
    }

    public static List<Report> GetSearchAllBeforeDate(String skeyword,Employee sname, Date bdate, EntityManager em) {
        List<Report> searches = em.createNamedQuery("getSearchAllBeforeDate", Report.class)
                                  .setParameter("skeyword", "%" + skeyword + "%")
                                  .setParameter("bdate", bdate)
                                  .setParameter("sname", sname)
                                  .getResultList();
        return searches;
    }

    public static long GetSearchNameCount(Employee sname, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchNameCount", Long.class)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchKeywordCount(String skeyword, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchKeywordCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchNameAndKeywordCount(Employee sname, String skeyword, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchNameAndKeywordCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchDateCount(Date adate, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchDateCount", Long.class)
                                      .setParameter("adate", adate)
                                      .setParameter("bdate", bdate)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchAfterDateCount(Date adate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchAfterDateCount", Long.class)
                                      .setParameter("adate", adate)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchNameAndDateCount(Employee sname, Date adate, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchNameAndDateCount", Long.class)
                                      .setParameter("adate", adate)
                                      .setParameter("bdate", bdate)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchNameAndAfterDateCount(Employee sname, Date adate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchNameAndAfterDateCount", Long.class)
                                      .setParameter("adate", adate)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchKeywordAndAfterDateCount(String skeyword, Date adate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchKeywordAndAfterDateCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("adate", adate)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchAllAfterDateCount(String skeyword,Employee sname, Date adate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchAllAfterDateCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("adate", adate)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchBeforeDateCount(Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchBeforeDateCount", Long.class)
                                      .setParameter("bdate", bdate)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchNameAndBeforeDateCount(Employee sname, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchNameAndBeforeDateCount", Long.class)
                                      .setParameter("bdate", bdate)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchKeywordAndBeforeDateCount(String skeyword, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchKeywordAndBeforeDateCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("bdate", bdate)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchAllBeforeDateCount(String skeyword,Employee sname, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchAllBeforeDateCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("bdate", bdate)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchKeywordAndDateCount(String skeyword, Date adate, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchKeywordAndDateCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("adate", adate)
                                      .setParameter("bdate", bdate)
                                      .getSingleResult();
        return reports_count;
    }

    public static long GetSearchAllCount(String skeyword,Employee sname, Date adate, Date bdate, EntityManager em) {
        long reports_count = (long) em.createNamedQuery("getSearchAllCount", Long.class)
                                      .setParameter("skeyword", "%" + skeyword + "%")
                                      .setParameter("adate", adate)
                                      .setParameter("bdate", bdate)
                                      .setParameter("sname", sname)
                                      .getSingleResult();
        return reports_count;
    }
}
