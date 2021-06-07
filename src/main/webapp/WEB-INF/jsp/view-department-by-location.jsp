<%@ include file="header.jsp" %>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">

        </div>
        <div class="col-sm-8">
            <div class = "text-center">
                <h2>Departments located in ${location}</h2>
            </div>
            <table class="table my-5">
                <thead class="text-center">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${departments}" var="department">
                    <tr class="text-center">
                        <td><a href="http://<%= baseURL %>/department/${department.id}">${department.id}</a></td>
                        <td><a href="http://<%= baseURL %>/department/${department.id}">${department.name}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>