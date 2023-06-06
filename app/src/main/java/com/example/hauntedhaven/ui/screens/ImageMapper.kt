package com.example.hauntedhaven.ui.screens

import com.example.hauntedhaven.R



class ImageMapper {
    fun getImageResourceIds(locationId: Int): List<Int> {
        val imageResourceIds = mutableListOf<Int>()

        // Map the location ID to image resource IDs
        when (locationId) {
            1 -> {
                // Location 1 image resources
                imageResourceIds.add(R.drawable.winchester)
                imageResourceIds.add(R.drawable.winchester2)
                // Add more image resources as needed
            }
            2 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.villisca)
                imageResourceIds.add(R.drawable.villisca2)
                // Add more image resources as needed
            }

            3 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.franklin)
                imageResourceIds.add(R.drawable.franklin2)
                // Add more image resources as needed
            }

            4 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.sevengables)
                imageResourceIds.add(R.drawable.sevengables2)
                // Add more image resources as needed
            }

            5 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.myrtles)
                imageResourceIds.add(R.drawable.myrtles2)
                // Add more image resources as needed
            }

            6 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.conjuring)
                imageResourceIds.add(R.drawable.conjuring2)
                // Add more image resources as needed
            }

            7 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.stanley)
                imageResourceIds.add(R.drawable.stanley2)
                // Add more image resources as needed
            }

            8 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.burchianti)
                imageResourceIds.add(R.drawable.burchianti2)
                // Add more image resources as needed
            }

            9 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.fairmont)
                imageResourceIds.add(R.drawable.fairmont2)
                // Add more image resources as needed
            }


            10 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.savoy)
                imageResourceIds.add(R.drawable.savoy2)
                // Add more image resources as needed
            }

            11 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.albans)
                imageResourceIds.add(R.drawable.albans2)
                // Add more image resources as needed
            }


            12 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.rolling)
                imageResourceIds.add(R.drawable.rolling2)
                // Add more image resources as needed
            }


            13 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.changi)
                imageResourceIds.add(R.drawable.changi2)
                // Add more image resources as needed
            }

            14 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.aradale)
                imageResourceIds.add(R.drawable.aradale2)
                // Add more image resources as needed
            }


            15 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.waverly)
                imageResourceIds.add(R.drawable.waverly2)
                // Add more image resources as needed
            }


            16 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.penitentiary)
                imageResourceIds.add(R.drawable.penitentiary2)
                // Add more image resources as needed
            }

            17 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.gaol)
                imageResourceIds.add(R.drawable.gaol2)
                // Add more image resources as needed
            }

            18 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.london)
                imageResourceIds.add(R.drawable.london2)
                // Add more image resources as needed
            }


            19 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.kilmainham)
                imageResourceIds.add(R.drawable.kilmainham2)
                // Add more image resources as needed
            }

            20 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.chateau)
                imageResourceIds.add(R.drawable.chateau2)
                // Add more image resources as needed
            }

            21 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.chillingham)
                imageResourceIds.add(R.drawable.chillingham2)
                // Add more image resources as needed
            }


            22 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.leap)
                imageResourceIds.add(R.drawable.leap2)
                // Add more image resources as needed
            }

            23 -> {
                // Location 2 image resources
                imageResourceIds.add(R.drawable.akershus)
                imageResourceIds.add(R.drawable.akershus2)
                // Add more image resources as needed
            }





            else -> {
                // Default image resources
                imageResourceIds.add(R.drawable.hauntedghostwhite)
            }
        }

        return imageResourceIds
    }
}
