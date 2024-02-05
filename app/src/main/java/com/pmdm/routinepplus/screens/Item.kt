package com.pmdm.routinepplus.screens

import android.media.Image
import androidx.annotation.DrawableRes

data class Exercices(
    var nameExercise: String,
    var description: String,
    @DrawableRes var picture: Int
)
