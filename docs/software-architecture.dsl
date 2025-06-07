workspace "Software Design & Patterns - C4 Model - Sistema de Monitoreo - 2025-10 - Renato Zegarra Lopez" {
    model {
        # Personas
        ciudadano = person "Ciudadano" "Ciudadano peruano."{
                tags "Ciudadano"
            }
            
        admin = person "Admin" "User Admin."{
                tags "Admin"
            }

        # Sistemas externos
        googleMaps = softwareSystem "Google Maps" "Plataforma que ofrece una REST API de información geo referencial."{
                tags "Google Maps"
            }
        aircraftSystem = softwareSystem "Aircraft System" "Permite transmitir información en tiempo real por el avión del vuelo a nuestro sistema."{
                tags "Aircraft System"
            }

        # Sistema principal
        monitoreo = softwareSystem "Monitoreo del Traslado Aéreo de Vacunas SARS-CoV-2" "Permite el seguimiento y monitoreo del traslado aéreo a nuestro país de las vacunas para la COVID-19" {
            tags "Monitoreo"
            # Contenedores
            mobileApp = container "Mobile App" "Permite a los usuarios visualizar un dashboard con el resumen de toda la informacion del traslado de los lotes de vacunas." "Flutter" "mobile"{
                tags "Mobile App"
            }
            landingPage = container "Landing Page" "Página informativa de acceso público." "HTML/CSS" "web"{
                tags "Landing Page"
            }
            webApp = container "Web App" "Permite a los usaurios visualizar un dashboard con el resumen del traslado de los lotes de vacunas." "Vue.js" "web"{
                tags "Web App"
            }

           apiRest = container "API REST" "API REST que expone los servicios del sistema para las apps web y móvil." "NodeJS (NestJS)" "api" {
           
                    tags "API REST"
                interfaceLayer = component "Interface Layer Aircrafts" " " "NestJS"{
                tags "ccomponent"
                }
                applicationLayer = component "Application Layer Aircrafts" " " "NestJS"{
                tags "ccomponent"
                }
                infrastructureLayer = component "Infrastructure Layer Aircrafts" " " "NestJS"{
                tags "ccomponent"
                }
                domainLayer = component "Domain Layer Aircrafts" " " "NestJS"{
                tags "ccomponent"
                }
                
                
                
                
                
                
                flights = component "Flights" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }
                airports = component "Airports" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }
                aircrafts = component "Aircrafts" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }
                security = component "Security" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }
                vaccines = component "Vaccines" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }
                monitoring = component "Monitoring" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }
                sharedKernel = component "Shared Kernel" " " "NodeJS (NestJS)"{
                tags "ccomponent"
                }

                
                
                
                
            }


            database = container "DB" " " "database" {
                tags "Database"
            }
            
            apiRestAirports = container "API REST Airports" " " "NodeJS (NestJS)" "api" {
                interfaceAirports = component "Interface Layer Airports" " " "NestJS"{
                tags "ccomponent"
                }
                applicationAirports = component "Application Layer Airports" " " "NestJS"{
                tags "ccomponent"
                }
                infrastructureAirports = component "Infrastructure Layer Airports" " " "NestJS"{
                tags "ccomponent"
                }
                domainAirports = component "Domain Layer Airports" " " "NestJS"{
                tags "ccomponent"
                }
            }
            
            apiRestFlights = container "API REST Flights" " " "NodeJS (NestJS)" "api" {
                interfaceFlights = component "Interface Layer Flights" " " "NestJS"{
                tags "ccomponent"
                }
                applicationFlights = component "Application Layer Flights" " " "NestJS"{
                tags "ccomponent"
                }
                infrastructureFlights = component "Infrastructure Layer Flights" " " "NestJS"{
                tags "ccomponent"
                }
                domainFlights = component "Domain Layer Flights" " " "NestJS"{
                tags "ccomponent"
                }
            }
            
            apiRestMonitoring = container "API REST Monitoring" "Contenedor para la gestión de monitoreo" "NodeJS (NestJS)" "api" {
                interfaceMonitoring = component "Interface Layer Monitoring" " " "NestJS"{
                tags "ccomponent"
                }
                applicationMonitoring = component "Application Layer Monitoring" " " "NestJS"{
                tags "ccomponent"
                }
                infrastructureMonitoring = component "Infrastructure Layer Monitoring" " " "NestJS"{
                tags "ccomponent"
                }
                domainMonitoring = component "Domain Layer Monitoring" " " "NestJS"{
                tags "ccomponent"
                }
                googleMapsConnector = component "Google Maps Connector" " " "NestJS"{
                tags "ccomponent"
                }
            }
            
            apiRestSecurity = container "API REST Security" "Contenedor para la gestión de seguridad" "NodeJS (NestJS)" "api" {
                interfaceSecurity = component "Interface Layer Security" " " "NestJS"{
                tags "ccomponent"
                }
                applicationSecurity = component "Application Layer Security" " " "NestJS"{
                tags "ccomponent"
                }
                infrastructureSecurity = component "Infrastructure Layer Security" " " "NestJS"{
                tags "ccomponent"
                }
                domainSecurity = component "Domain Layer Security" " " "NestJS"{
                tags "ccomponent"
                }
                securityComponent = component "Security Component" "Módulo especializado de seguridad (e.g. roles, permisos)" "NestJS"{
                tags "ccomponent"
                }
            }
            
            apiRestVaccines = container "API REST Vaccines" "Contenedor para la gestión de vacunas" "NodeJS (NestJS)" "api" {
                interfaceVaccines = component "Interface Layer Vaccines" " " "NestJS"{
                tags "ccomponent"
                }
                applicationVaccines = component "Application Layer Vaccines" " " "NestJS"{
                tags "ccomponent"
                }
                infrastructureVaccines = component "Infrastructure Layer Vaccines" " " "NestJS"{
                tags "ccomponent"
                }
                domainVaccines = component "Domain Layer Vaccines" " " "NestJS"{
                tags "ccomponent"
                }
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
        
        
        
        interfaceAirports -> applicationAirports " "
        applicationAirports -> infrastructureAirports " "
        applicationAirports -> domainAirports " "
        infrastructureAirports -> domainAirports " "
        infrastructureAirports -> database "Usa"
         # diagrama
        flights -> sharedKernel "Usa"
        airports -> sharedKernel "Usa"
        aircrafts -> sharedKernel "Usa"
        security -> sharedKernel "Usa"
        vaccines -> sharedKernel "Usa"
        monitoring -> sharedKernel "Usa"
        
        # diagrama
        flights -> database "Usa"
        airports -> database "Usa"
        aircrafts -> database "Usa"
        security -> database "Usa"
        vaccines -> database "Usa"
        monitoring -> database "Usa"

        monitoring -> googleMaps "Usa"
        monitoring -> aircraftSystem "Usa"

         # diagrama
        interfaceFlights -> applicationFlights " "
        applicationFlights -> infrastructureFlights " "
        applicationFlights -> domainFlights " "
        infrastructureFlights -> domainFlights " "
        infrastructureFlights -> database "Usa"

        
        # diagrama
        interfaceMonitoring -> applicationMonitoring " "
        applicationMonitoring -> infrastructureMonitoring " "
        applicationMonitoring -> domainMonitoring " "
        infrastructureMonitoring -> domainMonitoring " "
        infrastructureMonitoring -> database "Usa"
        googleMapsConnector -> googleMaps "JSON/HTTPS"
        infrastructureMonitoring -> googleMapsConnector ""
        infrastructureMonitoring -> aircraftSystem "JSON/HTTPS"

        
         # diagrama
        interfaceSecurity -> applicationSecurity " "
        applicationSecurity -> infrastructureSecurity " "
        applicationSecurity -> domainSecurity " "
        infrastructureSecurity -> domainSecurity " "
        infrastructureSecurity -> database "Uses"
        infrastructureSecurity -> securityComponent "Uses"
     
     
        interfaceVaccines -> applicationVaccines " "
        applicationVaccines -> infrastructureVaccines " "
        applicationVaccines -> domainVaccines " "
        infrastructureVaccines -> domainVaccines " "
        infrastructureVaccines -> database "Usa"


        
    }

views {
    systemContext monitoreo "SystemContext" "Diagrama de contexto del sistema de monitoreo" {
        include *
        autoLayout lr
    }

container monitoreo "Containers" "Diagrama de contenedores del sistema de monitoreo" {
    include mobileApp
    include admin
    include ciudadano
    include landingPage
    include webApp
    include apiRest
    include database
    include googlemaps
    include aircraftSystem
    autoLayout lr
}


    component apiRest "components-aircrafts" "Diagrama de componentes internos del API REST para Aircrafts" {
        include interfaceLayer
        include applicationLayer
        include infrastructureLayer
        include domainLayer
        include database
        autoLayout lr
    }

    component apiRestAirports "components-airports" "Diagrama de componentes internos del API REST para Airports" {
        include interfaceAirports
        include applicationAirports
        include infrastructureAirports
        include domainAirports
        include database
        autoLayout lr
    }

    component apiRest "components-bounded-contexts" "Vista general del API REST por bounded contexts" {
        include flights
        include airports
        include aircrafts
        include security
        include vaccines
        include monitoring
        include sharedKernel
        include database
        include googleMaps
        include aircraftSystem
        autoLayout lr
    }
    component apiRestFlights "components-flights" "Diagrama de componentes internos del API REST para Flights" {
        include interfaceFlights
        include applicationFlights
        include infrastructureFlights
        include domainFlights
        include database
        autoLayout lr
    }
    component apiRestMonitoring "components-monitoring" "Diagrama de componentes internos del API REST para Monitoring" {
        include interfaceMonitoring
        include applicationMonitoring
        include infrastructureMonitoring
        include domainMonitoring
        include googleMapsConnector
        include googleMaps
        include aircraftSystem
        include database
        autoLayout lr
    }
    component apiRestSecurity "components-security" "Diagrama de componentes internos del API REST para Security" {
        include interfaceSecurity
        include applicationSecurity
        include infrastructureSecurity
        include domainSecurity
        include securityComponent
        include database
        autoLayout lr
    }
    component apiRestVaccines "components-vaccines" "Diagrama de componentes internos del API REST para Vaccines" {
        include interfaceVaccines
        include applicationVaccines
        include infrastructureVaccines
        include domainVaccines
        include database
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
                element "Ciudadano" {
           
            background "#0084ff"
            color "#ffffff"
        }  
        element "Admin" {
            
            background "#ff00e8"
            color "#ffffff"
        }
        element "Monitoreo" {
            
            background "#24ac2d"
            color "#ffffff"
        }
        element "Google Maps" {
            
            background "#ab9d71"
            color "#ffffff"
        }
        element "Aircraft System" {
            
            background "#69d3f9"
            color "#ffffff"
        }
        element "Web App" {
            
            background "#a20085"
            color "#ffffff"
        }
        element "Landing Page" {
            
            background "#abd227"
            color "#ffffff"
        }
        element "Mobile App" {
            
            background "#a20085"
            color "#ffffff"
        }
        element "API REST" {
            
            background "#a20085"
            color "#ffffff"
        }
        element "ccomponent" {
            
            background "#f3ff00"
            color "#000000"
        }
        
    }

    theme default
}




    properties {
        structurizr.groupSeparator "/"
    }
}
