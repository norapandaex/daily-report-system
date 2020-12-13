package controllers.reports;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Report;
import utils.DBUtil;
import utils.SearchUtil;

/**
 * Servlet implementation class ReportSearchServlet
 */
@WebServlet("/reports/search")
public class ReportSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search_name = (String) request.getServletContext().getAttribute("search_name");
        String skeyword = (String) request.getServletContext().getAttribute("skeyword");
        String search_adate = (String) request.getServletContext().getAttribute("search_adate");
        String search_bdate = (String) request.getServletContext().getAttribute("search_bdate");

        EntityManager em = DBUtil.createEntityManager();

        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
        }

        if(!search_adate.equals("") || !search_bdate.equals("")){

            if(!search_adate.equals("") && !search_bdate.equals("")) {
                Date adate = Date.valueOf(search_adate);
                Date bdate = Date.valueOf(search_bdate);

                if (search_name != null && !search_name.equals("")) {
                    try {
                        Employee sname = SearchUtil.GetSearchNameEmployee(search_name, em);
                        if (skeyword != null && !skeyword.equals("")) {
                            try {

                                List<Report> searches = SearchUtil.GetSearchAll(skeyword, sname, adate, bdate, em);

                                long reports_count = SearchUtil.GetSearchAllCount(skeyword, sname, adate, bdate, em);

                                request.setAttribute("searches", searches);
                                request.setAttribute("reports_count", reports_count);
                            } catch (NoResultException ex) {
                                request.setAttribute("reports_count", 0);
                            }
                        } else {
                            try {
                                List<Report> searches = SearchUtil.GetSearchNameAndDate(sname, adate, bdate, em);

                                long reports_count = SearchUtil.GetSearchNameAndDateCount(sname, adate, bdate, em);

                                request.setAttribute("searches", searches);
                                request.setAttribute("reports_count", reports_count);
                            } catch (NoResultException ex) {
                                request.setAttribute("reports_count", 0);
                            }
                        }
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else if (skeyword != null && !skeyword.equals("")) {
                    try {
                        List<Report> searches = SearchUtil.GetSearchKeywordAndDate(skeyword, adate, bdate, em);

                        long reports_count = SearchUtil.GetSearchKeywordAndDateCount(skeyword, adate, bdate, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else {
                    try {
                        List<Report> searches = SearchUtil.GetSearchDate(adate, bdate, em);

                        long reports_count = SearchUtil.GetSearchDateCount(adate, bdate, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                }
            } else if(search_bdate.equals("")) {
                Date adate = Date.valueOf(search_adate);

                if (search_name != null && !search_name.equals("")) {
                    try {
                        Employee sname = SearchUtil.GetSearchNameEmployee(search_name, em);
                        if (skeyword != null && !skeyword.equals("")) {
                            try {

                                List<Report> searches = SearchUtil.GetSearchAllAfterDate(skeyword, sname, adate, em);

                                long reports_count = SearchUtil.GetSearchAllAfterDateCount(skeyword, sname, adate, em);

                                request.setAttribute("searches", searches);
                                request.setAttribute("reports_count", reports_count);
                            } catch (NoResultException ex) {
                                request.setAttribute("reports_count", 0);
                            }
                        } else {
                            try {
                                List<Report> searches = SearchUtil.GetSearchNameAndAfterDate(sname, adate, em);

                                long reports_count = SearchUtil.GetSearchNameAndAfterDateCount(sname, adate, em);

                                request.setAttribute("searches", searches);
                                request.setAttribute("reports_count", reports_count);
                            } catch (NoResultException ex) {
                                request.setAttribute("reports_count", 0);
                            }
                        }
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else if (skeyword != null && !skeyword.equals("")) {
                    try {
                        List<Report> searches = SearchUtil.GetSearchKeywordAndAfterDate(skeyword, adate, em);

                        long reports_count = SearchUtil.GetSearchKeywordAndAfterDateCount(skeyword, adate, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else {
                    try {
                        List<Report> searches = SearchUtil.GetSearchAfterDate(adate, em);

                        long reports_count = SearchUtil.GetSearchAfterDateCount(adate, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                }
            } else if(search_adate.equals("")) {
                Date bdate = Date.valueOf(search_bdate);

                if (search_name != null && !search_name.equals("")) {
                    try {
                        Employee sname = SearchUtil.GetSearchNameEmployee(search_name, em);
                        if (skeyword != null && !skeyword.equals("")) {
                            try {

                                List<Report> searches = SearchUtil.GetSearchAllBeforeDate(skeyword, sname, bdate, em);

                                long reports_count = SearchUtil.GetSearchAllBeforeDateCount(skeyword, sname, bdate, em);

                                request.setAttribute("searches", searches);
                                request.setAttribute("reports_count", reports_count);
                            } catch (NoResultException ex) {
                                request.setAttribute("reports_count", 0);
                            }
                        } else {
                            try {
                                List<Report> searches = SearchUtil.GetSearchNameAndBeforeDate(sname, bdate, em);

                                long reports_count = SearchUtil.GetSearchNameAndBeforeDateCount(sname, bdate, em);

                                request.setAttribute("searches", searches);
                                request.setAttribute("reports_count", reports_count);
                            } catch (NoResultException ex) {
                                request.setAttribute("reports_count", 0);
                            }
                        }
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else if (skeyword != null && !skeyword.equals("")) {
                    try {
                        List<Report> searches = SearchUtil.GetSearchKeywordAndBeforeDate(skeyword, bdate, em);

                        long reports_count = SearchUtil.GetSearchKeywordAndBeforeDateCount(skeyword, bdate, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else {
                    try {
                        List<Report> searches = SearchUtil.GetSearchBeforeDate(bdate, em);

                        long reports_count = SearchUtil.GetSearchBeforeDateCount(bdate, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                }
            }
    } else if (search_name != null && !search_name.equals("")) {
            try {
                Employee sname = SearchUtil.GetSearchNameEmployee(search_name, em);
                if (skeyword != null && !skeyword.equals("")) {
                    try {

                        List<Report> searches = SearchUtil.GetSearchNameAndKeyword(sname, skeyword, em);

                        long reports_count = SearchUtil.GetSearchNameAndKeywordCount(sname, skeyword, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                } else {
                    try {
                        List<Report> searches = SearchUtil.GetSearchName(sname, em);

                        long reports_count = SearchUtil.GetSearchNameCount(sname, em);

                        request.setAttribute("searches", searches);
                        request.setAttribute("reports_count", reports_count);
                    } catch (NoResultException ex) {
                        request.setAttribute("reports_count", 0);
                    }
                }
            } catch (NoResultException ex) {
                request.setAttribute("reports_count", 0);
            }
        } else if (skeyword != null && !skeyword.equals("")) {
            try {
                List<Report> searches = SearchUtil.GetSearchKeyword(skeyword, em);

                long reports_count = SearchUtil.GetSearchKeywordCount(skeyword, em);

                request.setAttribute("searches", searches);
                request.setAttribute("reports_count", reports_count);
            } catch (NoResultException ex) {
                request.setAttribute("reports_count", 0);
            }
        } else {
            List<Report> reports = em.createNamedQuery("getAllReports", Report.class)
                                     .setFirstResult(15 * (page -1))
                                     .setMaxResults(15)
                                     .getResultList();

            long reports_count = (long)em.createNamedQuery("getReportsCount", Long.class)
                                         .getSingleResult();

            request.getServletContext().setAttribute("searches", reports);
            request.setAttribute("reports_count", reports_count);
            request.setAttribute("flush", "検索ワードを入力してください。");
        }


        request.setAttribute("page", page);

        em.close();

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/search.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().setAttribute("search_name", request.getParameter("search_name"));
        request.getServletContext().setAttribute("skeyword", request.getParameter("search_keyword"));

        String search_adate = request.getParameter("search_adate");
        String search_bdate = request.getParameter("search_bdate");
        request.getServletContext().setAttribute("search_adate", search_adate);
        request.getServletContext().setAttribute("search_bdate", search_bdate);

        request.getSession().setAttribute("search_flag", 1);
        response.sendRedirect(request.getContextPath() + "/reports/search");
    }

}
