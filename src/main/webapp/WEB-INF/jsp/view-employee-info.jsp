
<%@ include file="header.jsp" %>
<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">

        </div>
        <div class="col-sm-8">
            <div class = "text-center">
                <h2>Employee Info</h2>
            </div>


            <table class="table my-5">
                <thead class="text-center">

                            </thead>
                            <tbody>
                            <tr class="text-center" scope="row">
                                <td><strong>Id</strong></td>
                                <td>${employee.id}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>First name</strong></td>
                                <td>${employee.firstName}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Last name</strong></td>
                                <td>${employee.lastName}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Job</strong></td>
                                <td>${employee.job}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Manager</strong></td>
                                <td>${employee.manager.lastName}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Hire date</strong></td>
                                <td>${employee.hireDate}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Salary</strong></td>
                                <td>${employee.salary}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Commission</strong></td>
                                <td>${employee.commission}</td>
                            </tr>
                            <tr class="text-center" scope="row">
                                <td><strong>Department</strong></td>
                                <td>${employee.department.name}</td>
                            </tr>

                            </tbody>
                        </table>

        </div>
    </div>
</div>



<%@ include file="footer.jsp" %>