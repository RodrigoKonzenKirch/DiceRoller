package com.example.diceroller.ui.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.R
import com.example.diceroller.ui.theme.DiceRollerTheme
import java.util.Random

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val diceFace = rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Dice(
            face = diceFace.value,
            modifier = modifier
        )
        Button(
            onClick = {
                diceFace.value = Random().nextInt(6) + 1
            }
        ) {
            Text(text = "Roll")
        }
    }
}

@Composable
fun Dice(
    face: Int,
    modifier: Modifier
){
    Surface(modifier = modifier) {
        Image(
            painter = when(face) {
                1 -> painterResource(id = R.drawable.dice_1)
                2 -> painterResource(id = R.drawable.dice_2)
                3 -> painterResource(id = R.drawable.dice_3)
                4 -> painterResource(id = R.drawable.dice_4)
                5 -> painterResource(id = R.drawable.dice_5)
                6 -> painterResource(id = R.drawable.dice_6)
                else -> painterResource(id = R.drawable.empty_dice)
            },
            contentDescription = when(face) {
                1 -> "Dice showing face 1"
                2 -> "Dice showing face 2"
                3 -> "Dice showing face 3"
                4 -> "Dice showing face 4"
                5 -> "Dice showing face 5"
                6 -> "Dice showing face 6"
                else -> "Dice showing empty face"
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
        MainScreen()
    }
}

