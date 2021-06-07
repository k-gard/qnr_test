<%@ include file="header.jsp" %>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">

        </div>
        <div class="col-sm-8">
            <div class ="text-center">
                <h2>Employees of ${department} Department</h2>
            </div>
            <table class="table my-5">
                <thead class="text-center">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr class="text-center">
                        <td><a href="http://<%= baseURL %>/employee/${employee.id}">${employee.id}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>



        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>