package com.vectorinc.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun showDefault() {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(8.dp))
        TopBar(name = "Vector Inc", Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        ProfileSection(modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(15.dp))
        ProfileDescription(
            displayName = "Native Android Developer",
            description = "4 years of coding experience, \n" + "" +
                    "Love playing video games and making android apps, \n" +
                    "Best food: Eba and Ewgusi soup,",
            url = "http://github.com/somtorizm",
            followedBy = listOf("codinginflow", "elonmusk"),
            otherCount = 20
        )
        Spacer(modifier = Modifier.height(15.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth().padding(10.dp))
        Spacer(modifier = Modifier.height(20.dp))





    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()

    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(7f)

        )
        Icon(
            painter = painterResource(id = R.drawable.bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
                .weight(1f)

        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dot_menu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.weight(1f)
        )

    }


}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                painterResource(id = R.drawable.linkedin),
                modifier = Modifier
                    .size(80.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(6.dp))
            StackSection(modifier = Modifier.weight(7f))
        }

    }

}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier,

    ) {
    Image(
        painter = image, contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun StackSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStatsItems(numberText = "20", text = "Posts")
        ProfileStatsItems(numberText = "40.1K", text = "Followers")
        ProfileStatsItems(numberText = "21", text = "Following")


    }

}

@Composable
fun ProfileStatsItems(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier

) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,

            )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)

    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {

    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,

            )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        )
        Text(
            text = url,
            color = Color.Blue,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {

                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,

                        )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1)
                            append(", ")

                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight

            )

        }

    }
}

@Composable
fun ButtonSection(
    modifier: Modifier
) {
    val minHeight= 40.dp
    val minWidth= 40.dp
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minHeight = minHeight)
                .height(minHeight)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight)
        )

    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(10.dp)
    ) {
        if (text!= null){
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp

            )
        }
        if (icon!=null){
            Icon(
                imageVector = icon,
                contentDescription =null,
                tint = Color.Black
            )
        }

        @Composable
        fun HighlightSection(){

        }

    }

}
