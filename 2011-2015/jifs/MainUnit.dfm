object MainForm: TMainForm
  Left = 192
  Top = 114
  Width = 674
  Height = 579
  AutoSize = True
  Caption = 'JIFS'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object MainImagePanel: TPanel
    Left = 0
    Top = 0
    Width = 545
    Height = 545
    TabOrder = 0
    object MainImage: TImage
      Left = 16
      Top = 16
      Width = 512
      Height = 512
    end
  end
  object DrawButtonPanel: TPanel
    Left = 545
    Top = 0
    Width = 121
    Height = 545
    TabOrder = 1
    object DrawButton: TButton
      Left = 22
      Top = 24
      Width = 75
      Height = 25
      Caption = 'Draw!'
      TabOrder = 0
      OnClick = DrawButtonClick
    end
  end
end
