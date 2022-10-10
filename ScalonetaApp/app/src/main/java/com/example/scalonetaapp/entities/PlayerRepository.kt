package com.example.scalonetaapp.entities

class PlayerRepository {

    private var playerList : MutableList<Player> = mutableListOf()

    init{
        playerList.add(Player("Damián Emiliano Martinez",
            "Arquero",
            "Buenos Aires, Argentina",
            29,
            1,
            "https://fifastatic.fifaindex.com/FIFA22/players/202811.png"
        ))

        playerList.add(Player("Franco Armani",
            "Arquero",
            "Santa Fe, Argentina",
            35,
            1,
            "https://fifastatic.fifaindex.com/FIFA22/players/214584.png"
        ))

        playerList.add(Player("Nicolás Alejandro Tagliafico",
            "Defensor",
            "Buenos Aires, Argentina",
            29,
            3,
            "https://fifastatic.fifaindex.com/FIFA22/players/211256.png"
        ))

        playerList.add(Player("Germán Pezzella",
            "Defensor",
            "Buenos Aires, Argentina",
            30,
            6,
            "https://fifastatic.fifaindex.com/FIFA22/players/193601.png"
        ))

        playerList.add(Player("Cristian Gabriel Romero",
            "Defensor",
            "Cordoba, Argentina",
            23,
            13,
            "https://fifastatic.fifaindex.com/FIFA22/players/232488.png"
        ))

        playerList.add(Player("Nicolás Otamendi",
            "Defensor",
            "Buenos Aires, Argentina",
            34,
            19,
            "https://fifastatic.fifaindex.com/FIFA22/players/192366.png"
        ))

        playerList.add(Player("Marcos Javier Acuña",
            "Defensor",
            "Neuquen, Argentina",
            30,
            8,
            "https://fifastatic.fifaindex.com/FIFA22/players/224334.png"
        ))

        playerList.add(Player("Lisandro Martínez",
            "Defensor",
            "Entre Rios, Argentina",
            24,
            6,
            "https://fifastatic.fifaindex.com/FIFA22/players/239301.png"
        ))

        playerList.add(Player("Lucas Martínez Quarta",
            "Defensor",
            "Buenos Aires, Argentina",
            25,
            2,
            "https://fifastatic.fifaindex.com/FIFA22/players/228708.png"
        ))

        playerList.add(Player("Juan Marcos Foyth",
            "Defensor",
            "Buenos Aires, Argentina",
            24,
            4,
            "https://fifastatic.fifaindex.com/FIFA22/players/237221.png"
        ))

        playerList.add(Player("Nahuel Molina Lucero",
            "Defensor",
            "Cordoba, Argentina",
            23,
            12,
            "https://fifastatic.fifaindex.com/FIFA22/players/233084.png"
        ))

        playerList.add(Player("Manuel Lanzini",
            "Mediocampista",
            "Buenos Aires, Argentina",
            29,
            24,
            "https://fifastatic.fifaindex.com/FIFA22/players/188988.png"
        ))

        playerList.add(Player("Guido Rodríguez",
            "Mediocampista",
            "Buenos Aires, Argentina",
            27,
            18,
            "https://fifastatic.fifaindex.com/FIFA22/players/225659.png"
        ))

        playerList.add(Player("Rodrigo Javier De Paul",
            "Mediocampista",
            "Buenos Aires, Argentina",
            27,
            7,
            "https://fifastatic.fifaindex.com/FIFA22/players/212616.png"
        ))

        playerList.add(Player("Leandro Daniel Paredes",
            "Mediocampista",
            "Buenos Aires, Argentina",
            27,
            5,
            "https://fifastatic.fifaindex.com/FIFA21/images/players/5/207439.png"
        ))

        playerList.add(Player("Giovani Lo Celso",
            "Mediocampista",
            "Santa Fe, Argentina",
            25,
            20,
            "https://fifastatic.fifaindex.com/FIFA22/players/226226.png"
        ))

        playerList.add(Player("Lucas Ariel Ocampos Lain",
            "Mediocampista",
            "Buenos Aires, Argentina",
            27,
            17,
            "https://fifastatic.fifaindex.com/FIFA22/players/205632.png"
        ))

        playerList.add(Player("Nicolás Iván González",
            "Mediocampista",
            "Buenos Aires, Argentina",
            24,
            15,
            "https://fifastatic.fifaindex.com/FIFA22/players/240690.png"
        ))

        playerList.add(Player("Exequiel Alejandro Palacios",
            "Mediocampista",
            "Tucuman, Argentina",
            23,
            14,
            "https://fifastatic.fifaindex.com/FIFA22/players/231521.png"
        ))

        playerList.add(Player("Alexis Mac Allister",
            "Mediocampista",
            "La Pampa, Argentina",
            23,
            28,
            "https://fifastatic.fifaindex.com/FIFA22/players/239837.png"
        ))

        playerList.add(Player("Ángel Fabián Di María",
            "Delantero",
            "Santa Fe, Argentina",
            34,
            11,
            "https://fifastatic.fifaindex.com/FIFA22/players/183898.png"
        ))

        playerList.add(Player("Lionel Andrés Messi",
            "Delantero",
            "Santa Fe, Argentina",
            34,
            10,
            "https://fifastatic.fifaindex.com/FIFA22/players/158023.png"
        ))

        playerList.add(Player("Lautaro Javier Martinez",
            "Delantero",
            "Buenos Aires, Argentina",
            24,
            22,
            "https://fifastatic.fifaindex.com/FIFA22/players/231478.png"
        ))

        playerList.add(Player("Carlos Joaquín Correa",
            "Delantero",
            "Tucuman, Argentina",
            27,
            16,
            "https://fifastatic.fifaindex.com/FIFA21/images/players/5/215330.png"
        ))

        playerList.add(Player("Ángel Martín Correa Martínez",
            "Delantero",
            "Santa Fe, Argentina",
            27,
            21,
            "https://fifastatic.fifaindex.com/FIFA22/players/214997.png"
        ))

        playerList.add(Player("Julián Álvarez",
            "Delantero",
            "Cordoba, Argentina",
            22,
            9,
            "https://fifastatic.fifaindex.com/FIFA22/players/246191.png"
        ))
    }

    fun getPlayers () : MutableList<Player>{
        return playerList
    }

}