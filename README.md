
# Skelegram

A Skript Addon that allows users to create Anvil GUIs to read user input.

# Tutorial

An in-depth tutorial written by me can be found on SkriptHub: <TO BE DONE>.

# Documentation

[![SkriptHubViewTheDocs](http://skripthub.net/static/addon/ViewTheDocsButton.png)](http://skripthub.net/docs/?addon=Skript-AnvilGUI)

## Effects

### Open Anvil GUI
```
open (anvilgui|anvil gui) %anvil% to %players%
```

Open an Anvil GUI to a player.

<details>
	<summary>Open Anvil GUI</summary>

        ```
            to be done
        ```
</details>

## Types

### Anvil GUI
```
%anvil%
anvil gui
event-anvil gui
```

This type holds all the information about an Anvil GUI.
You can create a new object with the new anvil gui expression and edit its content (such as the items) with the specific expressions. 

<details>
	<summary>Anvil GUI</summary>

		```
            to be done
		```

</details>

## Events

### Anvil GUI Close
```
on anvil gui close
```

Fires whenever an anvil gui created with this addon is closed. You can access the following values from this event:
event-text (content of the GUI when the GUI was closed), event-anvil gui (the original anvil object. You can access items in the anvil GUI or its inventory title with expressions below.)

<details>
	<summary>Uncloseable AnvilGUI</summary>

        ```
		to be done
		```
</details>

### Anvil GUI Click
```
on anvil gui click
```

Fires whenever an anvil gui created with this addon is clicked. You can access the following values from this event:
event-integer (index of slot that was clicked), event-text (content of the GUI when the GUI was clicked),
event-anvil gui (the original anvil object. You can access items in the anvil GUI or its inventory title with expressions below.)

<details>
	<summary>Anvil GUI Password</summary>

        ```
		to be done
		```
</details>

## Expressions

### New Anvil GUI
```
new anvil gui
[a] new anvil gui (named|with title) %string% with default text %string%
```

Returns a new anvil gui. If no title and default text are specified, it will use some placeholder text.

<details>
	<summary>AnvilGUI</summary>

		```
            to be done
		```
</details>

### Anvil GUI TItle
```
[the] title of %anvil%
```

Access the title (inventory name) of an Anvil GUI. In 1.12.2, the name of the AnvilGUI will not change when displayed.
This is not really an issue (other than for aesthetic) as the title is still saved and can be accessed (to check for specific anvil GUIs in events).

<details>
	<summary>AnvilGUI click</summary>

		```
		on telegram message:
            reply to telegram message event-telegram message with "Welcome!"
            set {_mess} to last sent message
            wait 5 seconds
            edit telegram message {_mess} to "5 second have passed! Wow!"
		```
</details>

### Anvil GUI Text
```
text of %anvil%
```

Access the default text of an AnvilGUI. This will be filled when the anvil is opened to a player.

### Anvil GUI Left Item
```
(left|right|output) (item|slot) of %anvil%
```

Access a specific item in the anvil GUI. You can set these to any itemstack. Please note that the server wipes and overwrites
the items in the output GUI when opened, so as of right now only changing the left and right item works.

<details>
	<summary>Anvil GUI Set Item</summary>

	```
	to be done
	```
</details>

## FAQ

#### How to get a Bot Token?

You can create a new bot (and get a bot token) by talking with @BotFather on telegram. Simply start that bot, follow the
steps to create and customize the bot, and then copy the token from the long message you will get!


#### The server takes a long time to reload!

When the Addon is disabled (on a reload or a restart), all of the active telegram sessions are stopped. Because of how telegram works, stopping a session can take up to 50 seconds. The best practice for this is to stop the server (instead of reloading it), but you can't do much about it.


#### Stopping a session takes a long time!

Stopping a session takes up to 50 seconds. When you execute the effect "clear all telegram sessions" it will try to stop all of them and wait for a confirmation from the API, which is delayed by about 50 seconds.

#### The console is getting spammed from an API error 409!

As the error says, it's because you are running multiple instances of the bot. Make sure that you are not using the same token on different skripts that control the bot. If the error persists, run the effect "clear all telegram sessions" and wait for it to be finished. (To know when its finished add a broadcast right after the effect)



