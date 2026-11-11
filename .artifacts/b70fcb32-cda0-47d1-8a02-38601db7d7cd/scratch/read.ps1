$file = Get-ChildItem 'C:\Users\nik20\Downloads\*Работа с анимацией.docx'
if (-not $file) {
    $file = Get-ChildItem 'C:\Users\nik20\Downloads\*.docx' | Select-Object -First 1
}
Copy-Item $file.FullName 'pz28.docx' -Force
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead('pz28.docx')
$entry = $zip.GetEntry('word/document.xml')
$reader = New-Object System.IO.StreamReader($entry.Open())
$content = $reader.ReadToEnd()
$reader.Close()
$zip.Dispose()
$xml = [xml]$content
foreach ($node in $xml.DocumentElement.GetElementsByTagName('w:t')) {
    Write-Output $node.InnerText
}
