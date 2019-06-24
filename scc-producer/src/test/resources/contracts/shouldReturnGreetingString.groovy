package contracts

import org.springframework.cloud.contract.spec.Contract
String name = "Katya"

Contract.make{
    request{
        method 'GET'
        urlPath"/say/hello/${name}"
    }
    response{
        status HttpURLConnection.HTTP_OK
        headers {
            header('Content-Length', "14")
        }
        body"Hello Katya!!!"
        //body ($(regex("Hello.+K.+" )))
        body($( consumer( "Hello ${name}!!!"), producer(regex("Hello.+K.+"))))
        headers { header( "aaaa", value(producer(regex('[0-9]{2}')))) }
    }
    priority(5)
}
