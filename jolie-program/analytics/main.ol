from .analyticsInterface import AnalyticsIFace
from console import Console
service Analytics {

    execution{ concurrent }

    inputPort IP {
        Location: "socket://localhost:5554"
        Protocol: sodep
        Interfaces: AnalyticsIFace
    }
    embed Console as Console
    main {
        [ addToLogs (req) ] {
            println@Console("Logged " + req.entry + " from: " + req.fromService)()
        }
    }
}