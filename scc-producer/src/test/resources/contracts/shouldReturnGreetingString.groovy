package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make{
    request{
        method 'GET'
        urlPath"say/hello/Katya"
    }
    response{
        status 200
        body"Hello Katya!!!"
        //headers {headers.contentLength() == 100}
        headers {header('Content-Length', "14")}
    }
}
