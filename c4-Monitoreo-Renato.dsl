
workspace "Software Design & Patterns - C4 Model - Sistema de Monitoreo - 2025-10 - Renato Zegarra Lopez" {
    model {
        # Personas
        ciudadano = person "Ciudadano" "Ciudadano peruano."
        admin = person "Admin" "User Admin."

        # Sistemas externos
        googleMaps = softwareSystem "Google Maps" "Plataforma que ofrece una REST API de información geo referencial."
        aircraftSystem = softwareSystem "Aircraft System" "Permite transmitir información en tiempo real por el avión del vuelo a nuestro sistema."

        # Sistema principal
        monitoreo = softwareSystem "Monitoreo del Traslado Aéreo de Vacunas SARS-CoV-2" "Permite el seguimiento y monitoreo del traslado aéreo a nuestro país de las vacunas para la COVID-19" {
            
            # Contenedores
            mobileApp = container "Mobile App" "Permite a los usuarios visualizar un dashboard con el resumen de toda la informacion del traslado de los lotes de vacunas." "Flutter" "mobile"
            landingPage = container "Landing Page" "Página informativa de acceso público." "HTML/CSS" "web"
            webApp = container "Web App" "Permite a los usaurios visualizar un dashboard con el resumen del traslado de los lotes de vacunas." "Vue.js" "web"

           apiRest = container "API REST" "API REST que expone los servicios del sistema para las apps web y móvil." "NodeJS (NestJS)" "api" {
                interfaceLayer = component "Interface Layer Aircrafts" " " "NestJS"
                applicationLayer = component "Application Layer Aircrafts" " " "NestJS"
                infrastructureLayer = component "Infrastructure Layer Aircrafts" " " "NestJS"
                domainLayer = component "Domain Layer Aircrafts" " " "NestJS"
            }


            database = container "DB" " " "database" {
                tags "Database"
            }
        }

        # Relaciones de personas con el sistema
        ciudadano -> monitoreo "Realiza consultas para mantenerse al tanto de la panificacion de los vuelos hasta la llegada del lote de vacunas al Peru"
        admin -> monitoreo "Realiza consultas para mantenerse al tanto de la planificacion de los vuelos hasta la llegada del lote de vacunas al Peru"

        ciudadano -> mobileApp "Consulta"
        ciudadano -> landingPage "Consulta"
        admin -> landingPage "Consulta"
        ciudadano -> webApp "Consulta"
        admin -> webApp "Consulta"
        admin -> mobileApp "Consulta"

        mobileApp -> apiRest "API Request"

        webApp -> apiRest "API Request"

        apiRest -> database " "
        apiRest -> googleMaps "API Request"
        apiRest -> aircraftSystem "API Request"
        
        interfaceLayer -> applicationLayer " "
        applicationLayer -> infrastructureLayer " "
        applicationLayer -> domainLayer " "
        infrastructureLayer -> domainLayer ""
        infrastructureLayer -> database "Usa"

        
        
        
    }

views {
    systemContext monitoreo "SystemContext" "Diagrama de contexto del sistema de monitoreo" {
        include *
        autoLayout lr
    }

    container monitoreo "Containers" "Diagrama de contenedores del sistema de monitoreo" {
        include *
        autoLayout lr
    }

    component apiRest "Components" "Diagrama de componentes internos del API REST" {
        include *
        autoLayout lr
    }

    styles {
        element "Person" {
            shape "Person"
            background "#2d76cb"
            color "#ffffff"
        }
        element "Software System" {
            background "#1168bd"
            color "#ffffff"
        }
        element "Container" {
            background "#438dd5"
            color "#ffffff"
        }
        element "API" {
            background "#2d91d3"
            color "#ffffff"
        }
        element "Database" {
            shape "Cylinder"
            background "#d32f2f"
            color "#ffffff"
        }
    }

    theme default
}



    properties {
        structurizr.groupSeparator "/"
    }
}
