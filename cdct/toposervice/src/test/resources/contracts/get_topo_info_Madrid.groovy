import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return city's name and orography"

    request {
        url "/api/topographicdetails/Barcelona"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: "Barcelona",
                landscape: "Flat"
        )
    }
}